package com.backend.examPortal.restController;

import com.backend.examPortal.entity.quiz.Answer;
import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;
import com.backend.examPortal.entity.quiz.Result;
import com.backend.examPortal.service.QuestionService;
import com.backend.examPortal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class QuestionController {

    QuestionService qService;
    QuizService quizService;

    @Autowired
    public QuestionController(QuestionService q, QuizService quiz)
    {
        qService = q;
        quizService = quiz;
    }

    @RequestMapping("/questions")
    public Set<Question> getQuestions(){
        return qService.getQuestions();
    }
    @RequestMapping("/question/{id}")
    public Question getQuestionById(@PathVariable int id){
        return qService.getQuestion(id);
    }

    @RequestMapping("/questionsOfQuiz/{id}")
    public List<Question> getQuestionByQuiz(@PathVariable int id){
        return qService.getQuestionByQuizId(id);
    }

    @RequestMapping("/addQuestion")
    public ResponseEntity<?> addQuestion(@RequestBody Question q)throws Exception{
        if(!q.isValidQuestion())
        {
            System.out.println("Invalid question");
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid question format.");
        }
        return ResponseEntity.ok(qService.addQuestion(q));
    }

    @RequestMapping("/addQuestions")
    public ResponseEntity<?> addQuestions(@RequestBody List<Question> questions)throws Exception{

        for (Question q : questions) {
            if(!q.isValidQuestion())
            {
                return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FORBIDDEN).body("invalid question format.");
            }
        }

        questions.forEach((q)->{
            qService.addQuestion(q);
        });

        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.OK).body("questions added.");
    }

    @RequestMapping("/getResult")
    public ResponseEntity<?> submitAnswers(@RequestBody List<Answer> answers)throws Exception{
        System.out.println("submission accepted");
        System.out.println(answers.get(0));
        int quizId = answers.get(0).getQuizId();
        Quiz quiz = quizService.getQuizById(quizId);
        int totalQues = qService.getQuestionByQuizId(quizId).size();
        int correctAns = 0;
        int totalMarks = quiz.gettotal_marks();

        for (Answer ans : answers) {
            int id = ans.getQuestionId();
            Question original = qService.getQuestion(id);
            if(original.getAnswer().equals(ans.getAnswer()))
            {
                correctAns = correctAns+1;
            }
        }
        double marksScored = ((double) correctAns/totalQues)*totalMarks;

        Result result = new Result(quizId, totalQues, totalMarks, correctAns,marksScored);
        return ResponseEntity.ok(result);

    }

}
