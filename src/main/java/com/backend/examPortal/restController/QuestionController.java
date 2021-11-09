package com.backend.examPortal.restController;

import com.backend.examPortal.entity.quiz.Question;
import com.backend.examPortal.entity.quiz.Quiz;
import com.backend.examPortal.entity.quiz.Result;
import com.backend.examPortal.service.QuestionService;
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


    @Autowired
    public QuestionController(QuestionService q)
    {
        qService = q;
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
    public ResponseEntity<?> submitAnswers(@RequestBody List<Question> questions)throws Exception{
        System.out.println(questions.get(0));
        Quiz quiz = questions.get(0).getQuiz();

        int quizId = quiz.getId();
        int totalQues = questions.size();
        int correctAns = 0;
        int totalMarks = quiz.gettotal_marks();

        for (Question q : questions) {
            int id = q.getId();
            Question original = qService.getQuestion(id);
            if(original.getAnswer().equals(q.getAnswer()))
            {
                correctAns = correctAns+1;
            }
        }
        double marksScored = ((double) correctAns/totalQues)*totalMarks;

        Result result = new Result(quizId, totalQues, totalMarks, correctAns, totalMarks);
        return ResponseEntity.ok(result);

    }

}
