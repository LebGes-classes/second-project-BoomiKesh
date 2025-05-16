public class ProductActionChoice {
    public ProductActionChoice(Place place,DocumentListing currentListing,int index){

        String type;
        try {
            place = (Storage) place;
            type = "Storage";
        }catch(Exception e){
            place = (SellingPlace) place;
            type = "SellingPlace";
        }
        if(type.equals("Storage")){
            System.out.println("Склад");
            new StorageActionChoice(place,currentListing,index);
        }else if(type.equals("SellingPlace")){
            new SellingPlaceActionChoice((SellingPlace)place,currentListing,index);
        }else{
            System.out.println("Ошибка");
        }
    }
}
