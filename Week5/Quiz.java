import java.util.*;
import java.time.LocalTime;

class Question {
    private String question;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private String correctOpt;
    
    String getQuestion() {
        return question;
    }

    String getOpt1() {
        return opt1;
    }

    String getOpt2() {
        return opt2;
    }

    String getOpt3() {
        return opt3;
    }

    String getOpt4() {
        return opt4;
    }

    String getAns() {
        return correctOpt;
    }
}

class QuizTimer implements Runnable {
    private static LocalTime endTime = LocalTime.now().plusSeconds(10);
    static void reset() {
        endTime = LocalTime.now().plusSeconds(10);
    }
    
    @Override
    public void run() {
        while(true) {
            if(endTime.getSecond() == LocalTime.now().getSecond()) {
                System.out.println("TIMEOUT");
                break;            
            }
        }
    }
}

class QuizRunner implements Runnable {
    @Override
    public void run() {
        
    }
}


public class Quiz {
    public static void main(String args[]) {
        //take quiz data as input from a file
        //init 2 threads
            //timer:one is daemon
            //main thread which iterates through a list of q
            //end the above iteration if
            //timeout from daemon thread
            //wrong answer
        QuizTimer quizTimer = new QuizTimer();
        QuizRunner quizRunner = new QuizRunner();

        quizTimer.setDaemon(true);
        quizRunner.start();
        quizTimer.start();
    }
}
