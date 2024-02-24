package com.example.product_page;

import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Product {

    private String name, id, description;
    private int quantity, color,price, imageUrl;





   static List<Product> asianList = Arrays.asList(new Product[]{
           new Product("Asian short ribs with herb salad",
                   R.drawable.asian_short_ribs,
                   "asian",
                   20,
                   "A Thai-style beef recipe that’s made in a pressure cooker – the meat becomes melt-in-the-mouth in its rich sauce.",
                   10,
                   12),

           new Product("Spicy coconut noodle soup"
                   , R.drawable.spicy_coconut_noodle_soup,
                   "asian",
                   15,
                   "Asian food needn’t be complicated – this simple soup is made in just one bowl, too",
                   11,
                   12),

           new Product("Fried dumplings",
                   R.drawable.dumbling2,
                   "asian",
                   10,
                   " the pan fried dumpling is a crispy and juicy package that bursts with flavour, thanks to the fillings of pork, prawns, ginger and seasoning.",
                   20,
                   12),

           new Product("Kimchi",
                   R.drawable.kimchi1,
                   "asian",
                   9,
                   "Make a vegan version of kimchi (or kimchee) from this simple Korean recipe. Enjoy the umami flavors of the seaweed, whether you follow a plant-based diet or not",
                   12,
                   12),

           new Product("Asian prawn noodles",
                   R.drawable.asian_prawn_noodles,
                   "asian",
                   20,
                   "Whip up this healthy noodle pot in no time. The spicy, sour Asian flavors match with leftover chicken, too, which you can add at the end instead of prawns",
                   10,
                   12),

           new Product("Asian tofu with stir-fried noodles",
                   R.drawable.asian_tofu,
                   "asian",
                   8,
                   "A vegetarian stir-fry packed with spice and flavor. Marinate tofu in ginger, garlic and sesame and serve with a vermicelli noodle mix",
                   10,
                   12),

           new Product("tteokbokki",
                   R.drawable.tteokbokki,
                   "asian",
                   9,
                   "Tteokbokki is probably THE most famous street food from Korea: chewy rice cakes simmered in an addictive mix of sweet, savory, spicy sauce.",
                   10,
                   12),

   });


   static List<Product> italianList = Arrays.asList(new Product[]{
            new Product("Italian pork patties with potato wedges",
                    R.drawable.italian_pork_patties,
                    "italian",
                    15,
                    "Contains pork – recipe is for non-Muslims only Bring some Italian flavor to your table this week, with these succulent pork patties",
                    10,
                    12),

            new Product("Italian veggie cottage pie"
                    , R.drawable.italian_veggie_cottage,
                    "italian",
                    10,
                    "An Italian twist on an English classic, with sundried tomato, spinach and aubergine, this veggie pie makes a super budget supper",
                    11,
                    12),

            new Product("Classic Italian lasagne",
                    R.drawable.classic_italian_lasagne,
                    "italian",
                    10,
                    " Theo Randall shares his authentic Italian lasagne recipe, with a creamy béchamel sauce and classic defined layers. Everyone's favorite family meal.",
                    20,
                    12),

            new Product("Italian kale",
                    R.drawable.italian_kale,
                    "italian",
                    9,
                    "This vibrant green side dish has been flavored and dressed with vinegar, which gives it a sweet and sour flavor that'll keep you coming back for more",
                    12,
                    12),

            new Product("Italian meatball & mozzarella pasta bake",
                    R.drawable.italian_meatball,
                    "italian",
                    20,
                    "This cheesy, bubbling meatball and mozzarella pasta bake is the ultimate comforting weeknight supper. This family-friendly recipe is a true crowd-pleaser.",
                    10,
                    12),

            new Product("Sea bass & seafood Italian one-pot",
                    R.drawable.sea_bass_seafood,
                    "italian",
                    8,
                    "A one-pot fish stew with shellfish and all the fresh flavours of the Mediterranean – serve with plenty of bread for dipping.",
                    10,
                    12),


    });

    static List<Product> sweetList = Arrays.asList(new Product[]{
            new Product("Halwa",
                    R.drawable.halwa,
                    "sweet",
                    15,
                    "Try whipping up some halwa, a traditional Indian dessert made from either semolina or carrots, plus nuts and cardamom. Ours is made with semolina",
                    10,
                    12),

            new Product("Vegan custard"
                    , R.drawable.vegan_custard,
                    "sweet",
                    10,
                    "Make our vegan coconut custard to pour over your favorite desserts. Made with coconut milk, it pairs beautifully with our carrot, coconut & date pudding",
                    11,
                    12),

            new Product("The devil’s chocolate",
                    R.drawable.devil_chocolate,
                    "sweet",
                    10,
                    " Enjoy this luxurious no-bake dark chocolate dessert. Made with amaretti biscuits and amaretto liqueur, it’s a perfect grown up dessert for a dinner party",
                    20,
                    12),

            new Product("Cranberry & clementine polenta cake with zesty cinnamon cream",
                    R.drawable.cranberry,
                    "sweet",
                    9,
                    "Make a festive polenta cake with cranberry and clementine flavours and a cinnamon cream to serve. It’s a fabulous dessert at Christmastime",
                    12,
                    12),

            new Product("Perfect pavlova",
                    R.drawable.perfect_pavlova,
                    "sweet",
                    20,
                    "Make one of the most iconic summer desserts – pavlova. This recipe boasts a crisp, white shell and marshmallowy centre. It’s perfect for al fresco dining",
                    10,
                    12),

            new Product("Giant hot cookie pie",
                    R.drawable.gianthot,
                    "sweet",
                    8,
                    "Combine cookie dough and brownie batter – two of the most decadent desserts you can eat – to make this seriously indulgent giant cookie pie. Share it warm straight from the pan",
                    10,
                    12),
            new Product("Sweet shortcrust pastry",
                    R.drawable.sweetshortcrustpastry,
                    "sweet",
                    8,
                    "Learn how to make sweet shortcrust pastry. You'll be surprised how easy it is, then you can make all sorts of desserts like our apple and blackberry pies",
                    10,
                    12),
            new Product("Prosecco cake",
                    R.drawable.prosecco_cake,
                    "sweet",
                    8,
                    "The perfect cake for Prosecco lovers, with the Italian tipple finding its way into the cake, boozy buttercream and Prosecco-flavoured sweet topping",
                    10,
                    12),



    });


    public Product(String name, int url, String id, int price, String description, int quantity, int color) {
        this.name = name;
        this.imageUrl = url;
        this.id = id;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.color = color;

    }


    public String getToday() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String day = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
        return day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}

