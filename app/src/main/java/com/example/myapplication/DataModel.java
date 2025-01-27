package com.example.myapplication;

public class DataModel {



        private String name;
        private String priceDescription;
        private String version;
        private int image; // Integer
        private int id_;
        private int count;
        private int price;

    public int getId_() {
        return id_;
    }

    public void setId_(int id_) {
        this.id_ = id_;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String  getPriced() {
        return priceDescription;
    }
    public void setPriced(String priceDescription) {
        this.priceDescription = priceDescription;
    }

    public double getPrice() {
        return price;
    }
//    public void setPrice_(double price) {
//        this.price = price;
//    }

    public DataModel(String name, String priceDescription, int image, int id_, int count) {
            this.name = name;
            this.priceDescription = priceDescription;
            this.image = image;
            this.id_ = id_;
            this.count = 0;
        // this.price = price;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public void setImage(int image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getVersion() {
            return version;
        }

        public int getId() {
            return id_;
        }

        public int getImage() {
            return image;
        }

    public void incrementCount() {
        this.count++;
    }

    public void decrementCount() {
        if (this.count > 0) {
            this.count--;
        }
    }

}









