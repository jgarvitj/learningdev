import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    void setQuestion(String str) {
        question = str;
    }

    void setOpt1(String str) {
        opt1 = str;
    }

    void setOpt2(String str) {
        opt2 = str;
    }

    void setOpt3(String str) {
        opt3 = str;
    }

    void setOpt4(String str) {
        opt4 = str;
    }

    void setAns(String str) {
        correctOpt = str;
    }
}

class QuizTimer implements Runnable{
    private static LocalTime endTime = LocalTime.now().plusSeconds(2);
    private static boolean quitQuiz = false;

    static public boolean getQuitStatus() {
        return quitQuiz;
    }

    static public void quitNow() {
        quitQuiz = true;
    }

    static void reset() {
        System.out.println("reset");
        endTime = LocalTime.now().plusSeconds(2);
    }

    @Override
    public void run() {
        while(!quitQuiz) {
            if(endTime.isBefore(LocalTime.now())) {
                System.out.println("TIMEOUT");
                quitQuiz = true;
                break;            
            }    
        }
    }
}

class QuizRunner implements Runnable {
    
    static private int score = 0;
    //ArrayList<Question> readq = new ArrayList<Question>();
    static ArrayList<Question> questionList = new ArrayList<Question>();
    static private int index = 0;
    static private int numberofq = QuizRunner.questionList.size();

    static public void increaseScore() {
        score++;
    }

    static public int getScore() {
        return score;
    }

    // public void getQuestionList() {
    //     BufferedReader br = new BufferedReader(new FileReader("quiz.txt"));
    //     String line = null;
    //     while((line = br.readLine()) != null) {
    //         Question q = new Question();
    //         q.setQuestion(line);
    //         q.setOpt1(br.readLine());
    //         q.setOpt2(br.readLine());
    //         q.setOpt3(br.readLine());
    //         q.setOpt4(br.readLine());
    //         q.setAns(br.readLine());
    //         questionList.add(q);
            
    //     }
    //     br.close();
    // }

    static public Question nxtQuestion() {
        System.out.println("nxt q");
        if(index >= numberofq) {
            System.out.println(numberofq);
        
            QuizTimer.quitNow();
            return null;
        }
        else {
            System.out.println("nxt q");
        
            Question question = QuizRunner.questionList.get(index);
            System.out.println(question.getQuestion());
            System.out.println(question.getOpt1());
            System.out.println(question.getOpt2());
            System.out.println(question.getOpt3());
            System.out.println(question.getOpt4());
            QuizTimer.reset();
            index++;
            return question;
        }
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        //getQuestionList();
        while(!QuizTimer.getQuitStatus()) {
            Question question = new Question();
            try {
                question = nxtQuestion();
            }
            catch(NullPointerException e) {
                System.out.println("questions finished");
                break;
            }
            String option = sc.nextLine();

            if(option.equals(question.getAns())) {
                increaseScore();
            }
            else {
                System.out.println("Wrong answer");
            }
        }
        sc.close();
        System.out.println("Score: " + score);    
        QuizTimer.quitNow();
    }
}


public class Quiz {
    
    public static void getQuestionList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("quiz.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            Question q = new Question();
            q.setQuestion(line);
            q.setOpt1(br.readLine());
            q.setOpt2(br.readLine());
            q.setOpt3(br.readLine());
            q.setOpt4(br.readLine());
            q.setAns(br.readLine());
            QuizRunner.questionList.add(q);
            System.out.println("nxt q");
        }
        br.close();
    }

    public static void main(String args[]) throws InterruptedException {
        // take quiz data as input from a file
        // init 2 threads
        // main thread which iterates through a list of q
        // end the above iteration if
        // timeout from daemon thread
        // wrong answer
        QuizTimer quizTimer = new QuizTimer();
        QuizRunner quizRunner = new QuizRunner();
        Thread timerThread = new Thread(quizTimer);
        Thread runnerThread = new Thread(quizRunner);
        // timer:one is daemon
        timerThread.setDaemon(true);
        runnerThread.start();
        try {
            getQuestionList();
        }
        catch(IOException e) {
            System.out.println("io exception caught");
        }
        timerThread.start();
        /*while() {
            //
            System.out.println(i);
            quizRunner.nxtQuestion();
            Thread.sleep(2000);
            QuizTimer.reset();
        }*/
        timerThread.join();
    }
}
