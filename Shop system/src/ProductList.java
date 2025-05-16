public class ProductList {
    private String placeName;
    private String placeType;
    public ProductList(String full_name,Product[] product_list){
        String temp = "";
        for (int i = 0;full_name.charAt(i)!=' ';i++){
            temp = temp + full_name.charAt(i);
        }
        this.placeType = temp;
        this.placeName = full_name;
    }
}
