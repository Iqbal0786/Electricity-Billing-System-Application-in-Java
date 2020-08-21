
package electricity.billing.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
    private Pattern  email;
    private Pattern phone;
    private Pattern address;
    private Pattern name;
    private Pattern City;
    private Pattern State;
    private Pattern meterNO;
    private Pattern password;
    private Matcher matcher;
    
    private static final String NamePattern="^[ A-Za-z]{3,25}$";           
    private static final String MeterNO_Pattern="^[0-9]{1,10000}$";
    private static final String StatePattern="^[ A-Za-z]{5,30}$";
    private static final String CityPattern="^[ A-Za-z]{8,50}$";
    private static final String AddressPattern="^[ A-Za-z]{8,30}$";
    private static final String PhonePattern="^[0-9]{10}$";
    private static final String PasswordPattern="^[ A-Za-z0-9@#$]{8,16}$";
    private static final String EmailPattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z-]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,3})$";
    public Validation(){
               
               name= Pattern.compile(NamePattern);
               meterNO=Pattern.compile(MeterNO_Pattern);
               State=Pattern.compile(StatePattern);
               City= Pattern.compile(CityPattern);
               address=Pattern.compile(AddressPattern);
               phone= Pattern.compile(PhonePattern);
               password= Pattern.compile(PasswordPattern);
               
               email= Pattern.compile(EmailPattern);
               
               
                  }
    
      public boolean nameValidate(final String name1){
     
        matcher= name.matcher(name1);
        return matcher.matches();
 
             }
      public boolean meternoValidate(final String meterNo1){
      
         matcher= meterNO.matcher(meterNo1);
         return matcher.matches();
         }
      public boolean addressValidate(final String address1){
      
       matcher= address.matcher(address1);
       return matcher.matches();
      }
      public boolean stateValidate(final String state1){
      
      matcher= State.matcher(state1);
      return matcher.matches();
      
      }
      public boolean cityValidate(final String city1){
      matcher= City.matcher(city1);
      return matcher.matches();
      
      }
      public boolean emailValidate(final String email1){
      
      matcher= email.matcher(email1);
      return matcher.matches();
      
      }
      public boolean phoneValidate(final String phone1){
       matcher= phone.matcher(phone1);
       return matcher.matches();
      
      }
      public boolean passwordValidate(final String password1){
      matcher= password.matcher(password1);
      return matcher.matches();
      
      }
      
}
