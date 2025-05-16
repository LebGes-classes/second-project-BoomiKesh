public class Employee {
    private String first_name;
    private String second_name;
    private Place workingPlace;

    public Employee(String first_name,String second_name){
        this.first_name = first_name;
        this.second_name = second_name;
        this.workingPlace = null;
    }
    public Employee(String full_name){
        String first_name = "";
        String second_name = "";
        boolean flag=false;
        for (int i=0;i<full_name.length();i++){
            if(full_name.charAt(i)==' '){
                flag = true;
                continue;
            }
            if(flag==false){
                first_name = first_name+full_name.charAt(i);
            }else{
                second_name = second_name+full_name.charAt(i);
            }
        }
        this.first_name = first_name;
        this.second_name=second_name;
    }
    public Employee(String first_name,String second_name,Place workingPlace){
        this.first_name = first_name;
        this.second_name = second_name;
        this.workingPlace = workingPlace;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public Place getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(Place workingPlace) {
        this.workingPlace = workingPlace;
    }
    public String getFullName(){
        return first_name+" "+second_name;
    }

    public void getInfo(){
        System.out.println("Имя: "+ first_name);
        System.out.println("Фамилия: "+ first_name);
        if (workingPlace!=null) {
            System.out.println("Ответственный за: "+ first_name);
        }
    }
}
