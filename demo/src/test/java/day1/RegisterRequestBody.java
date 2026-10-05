package day1;

public class RegisterRequestBody {
    private String email;
    private String password;
   

    public RegisterRequestBody(String email, String password){
        this.email = email;
        this.password =  password;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public String toString() {
        return "RegisterRequestBody {email=" + email + '\'' +", password=" + password +'\'' + "}";
    }

   
}
