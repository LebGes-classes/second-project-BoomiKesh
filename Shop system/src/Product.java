import java.sql.SQLOutput;

public class Product {
    private String name;
    private int amount;
    private int price;
    public Product(String full_name){
        int bracket_index = -1;
        int first_space_index=-1;
        int second_space_index=-1;
        int price_index=-1;
        int amount_index=-1;
        String tempName="";
        String stringPrice = "";
        String stringAmount = "";
        boolean bracket_flag = false;
        boolean first_flag=false;
        //boolean second_flag = false;
        for (int i=0; i < full_name.length()-1;i++){
            if(full_name.charAt(i)==' ' && bracket_flag==false){
                bracket_index = i;
                bracket_flag = true;
            }
            if(full_name.charAt(i)==' ' && first_flag==false){
                first_space_index=i;
            }
            if(full_name.charAt(i)==' '){
                second_space_index=i;
            }
            if(""+full_name.charAt(i)+full_name.charAt(i+1)=="ru"){
                price_index = i;
                first_flag = true;
            }
            if(full_name.charAt(i)=='-') {
                amount_index = i;
            }

        }
        for(int i=bracket_index+1;i<first_space_index;i++){
            tempName = tempName + full_name.charAt(i);
        }
        this.name = tempName;
        for(int i=first_space_index+1;i<price_index;i++){
            stringPrice = stringPrice + full_name.charAt(i);
            this.price = Integer.valueOf(stringPrice);
        }
        for(int i=second_space_index+1;i<amount_index;i++){
            stringAmount = stringAmount + full_name.charAt(i);
            this.amount = Integer.valueOf(stringAmount);
        }
    }

    public String getName(){
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
