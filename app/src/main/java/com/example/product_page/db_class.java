package com.example.product_page;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class db_class extends SQLiteOpenHelper {


    private  static String databaseName="productsDatabase";
    SQLiteDatabase ProductDatabase;

    public db_class(Context context){
        super(context,databaseName,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d("CREATEUSER","Creating ordertable Table");
        sqLiteDatabase.execSQL("create table ordertable(id integer primary key," +
                "user_id text not null,product_id text ,count integer,total_price integer,orderDate text,orderHour integer)");


        Log.d("CREATEUSER","Creating product Table");
        sqLiteDatabase.execSQL("create table product(id integer primary key," +
                "idProduct text not null,name text ,imgUrl integer,price integer,description text,quantity integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists product");
        sqLiteDatabase.execSQL("drop table if exists ordertable");
        onCreate(sqLiteDatabase);
    }

    public void createnewProduct(String id,String name,int url,int price,String desc ,int quan){
        ContentValues row=new ContentValues();
        row.put("idProduct" ,id);
        row.put("name",name);
        row.put("imgUrl", url);
        row.put("price",price);
        row.put("description",desc);
        row.put("quantity",quan);
        ProductDatabase=getWritableDatabase();
        ProductDatabase.insert("product",null,row);
        ProductDatabase.close();
    }

    public Cursor fetchAllProduct(){
        ProductDatabase=getReadableDatabase();
        String[] rowdetalis={"idProduct","name","imgUrl","price","description","quantity"};
        Cursor cursor =ProductDatabase.query("product",rowdetalis,null,null,null,null,null);
        if(cursor!= null){
            cursor.moveToFirst();
        }
        ProductDatabase.close();
        return cursor;
    }

    public  void createAsianList()
    {
        for (Product val:Product.asianList) {
            createnewProduct(val.getId(),val.getName(),val.getImageUrl(),val.getPrice(),val.getDescription(),val.getQuantity());
        }
    }

    public  void createItalianList()
    {
        for (Product val:Product.italianList) {
            createnewProduct(val.getId(),val.getName(),val.getImageUrl(),val.getPrice(),val.getDescription(),val.getQuantity());
        }
    }

    public  void createSweetsList()
    {
        for (Product val:Product.sweetList) {
            createnewProduct(val.getId(),val.getName(),val.getImageUrl(),val.getPrice(),val.getDescription(),val.getQuantity());
        }
    }

    public Cursor fetchCurcorProduct(String ListName)
    {
        ProductDatabase=getWritableDatabase();
        String[] listname = {ListName};
        Cursor cursor = ProductDatabase.rawQuery("Select * from Product where idProduct like ?" , listname);
        if(cursor!= null)
            cursor.moveToFirst();
        ProductDatabase.close();
        return cursor;
    }

    public List<Product> getAsianList(){
        ArrayList<Product> asianList = new ArrayList<Product>();
        Cursor cursor = fetchCurcorProduct("asian");
        while (!cursor.isAfterLast())
        {
            Product p = new Product(cursor.getString(2),Integer.valueOf(cursor.getString(3)),cursor.getString(1),Integer.valueOf(cursor.getString(4)),cursor.getString(5),Integer.valueOf(cursor.getString(6)),14);
            asianList.add(p);
            cursor.moveToNext();
        }
        return asianList;
    }

    public List<Product> getItalianList(){
        ArrayList<Product> ItalianList = new ArrayList<Product>();
        Cursor cursor = fetchCurcorProduct("italian");
        while (!cursor.isAfterLast())
        {
            Product p = new Product(cursor.getString(2),Integer.valueOf(cursor.getString(3)),cursor.getString(1),Integer.valueOf(cursor.getString(4)),cursor.getString(5),Integer.valueOf(cursor.getString(6)),14);
            ItalianList.add(p);
            cursor.moveToNext();
        }
        return ItalianList;
    }

    public List<Product> getSweetsList(){
        ArrayList<Product> SweetsList = new ArrayList<Product>();
        Cursor cursor = fetchCurcorProduct("sweet");
        while (!cursor.isAfterLast())
        {
            Product p = new Product(cursor.getString(2),Integer.valueOf(cursor.getString(3)),cursor.getString(1),Integer.valueOf(cursor.getString(4)),cursor.getString(5),Integer.valueOf(cursor.getString(6)),14);
            SweetsList.add(p);
            cursor.moveToNext();
        }
        return SweetsList;
    }

    public Product getProduct(String Product_Name){
        ProductDatabase=getWritableDatabase();
        String[] listname = {Product_Name};
        Cursor cursor = ProductDatabase.rawQuery("Select * from Product where name like ?" , listname);
        if(cursor!= null)
            cursor.moveToFirst();
        ProductDatabase.close();
        Product p = new Product(cursor.getString(2),Integer.valueOf(cursor.getString(3)),cursor.getString(1),Integer.valueOf(cursor.getString(4)),cursor.getString(5),Integer.valueOf(cursor.getString(6)),14);
        return p;
    }

    public boolean QuantityEmpty(String productid){
        ProductDatabase=getWritableDatabase();
        String[] listname = {productid};
        Cursor cursor = ProductDatabase.rawQuery("Select * from Product where name like ?" , listname);
        if(cursor!= null)
            cursor.moveToFirst();
        ProductDatabase.close();
        int q = Integer.valueOf(cursor.getString(6));
        if(q == 0)
            return true;
        else return false;

    }

    public void UpdateQuantity(String productName , int newquantity)
    {
        Product p = getProduct(productName);
        ProductDatabase = getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put("idProduct" ,p.getId());
        row.put("name",p.getName());
        row.put("imgUrl", p.getImageUrl());
        row.put("price",p.getPrice());
        row.put("description",p.getDescription());
        row.put("quantity",newquantity);
        ProductDatabase.update("product",row,"name like ?",new String[]{productName});
        ProductDatabase.close();

    }

    //----------------------------------------order Table Func.-----------------------------

    public void createnew_order(String user_id,String product_id,int count,int total_price,String orderDate ,int orderHour){
        ContentValues row=new ContentValues();
        row.put("user_id" ,user_id);
        row.put("product_id",product_id);
        row.put("count", count);
        row.put("total_price",total_price);
        row.put("orderDate",orderDate);
        row.put("orderHour",orderHour);
        ProductDatabase=getWritableDatabase();
        ProductDatabase.insert("ordertable",null,row);
        ProductDatabase.close();
    }

    public Cursor fetchCurcorOrder(String userName)
    {
        ProductDatabase=getWritableDatabase();
        String[] username = {userName};
        Cursor cursor = ProductDatabase.rawQuery("Select * from ordertable where user_id like ?" , username);
        if(cursor!= null)
            cursor.moveToFirst();
        ProductDatabase.close();
        return cursor;
    }

    public List<Order> getUserList(String user_id){
        ArrayList<Order> ordersList = new ArrayList<>();
        Cursor cursor = fetchCurcorOrder(user_id);
        while (!cursor.isAfterLast())
        {
            Product p = getProduct(cursor.getString(2));
            Order o = new Order(cursor.getString(1),p,Integer.valueOf(cursor.getString(3)),Integer.valueOf(cursor.getString(6)));
            ordersList.add(o);
            cursor.moveToNext();
        }
        return ordersList;
    }



}
