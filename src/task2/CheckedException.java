package task2;

public class CheckedException extends Exception{
    private String messege;

    public CheckedException(String messege){
        this.messege = messege;
    }

    public void invoke(){
        System.out.println("CheckedException");
        System.out.println(messege);
    }
}
