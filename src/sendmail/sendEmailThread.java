/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmail;



/**
 *
 * @author Administrator
 */
public class sendEmailThread implements Runnable {

    String fromemail = "";
    String toemail = "";
    String Subject = "";
    String message = "";
    String password = "";
    String Attachment = "";
    String Attachment1 = "";
    String Attachment2 = "";

    public sendEmailThread(String frmemail, String temail, String sbject, String msg, String pwd,String attchment,String attchment1,String attchment2) {
        fromemail = frmemail;
        toemail = temail;
        Subject = sbject;
        message = msg;
        password = pwd;
       Attachment = attchment;
       Attachment1 = attchment1;
       Attachment2 = attchment2;

    }

    @Override
    public void run() {
        try {
            SimpleSendEmail smp = new SimpleSendEmail(fromemail, toemail, Subject, message, password,Attachment,Attachment1,Attachment2);
        } catch (Exception e) {
        }
    }
  
  
    public static void main(String[] args)
    {
        sendEmailThread s = new sendEmailThread("nssbeproject@gmail.com", "savedana@gmail.com",
                "Online Shoping Center", "Hi", "database", "build.xml","build.xml","build.xml");
         Thread t = new Thread(s);
        t.start();
    }
    
}
