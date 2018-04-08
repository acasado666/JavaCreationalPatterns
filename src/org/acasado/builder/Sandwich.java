package org.acasado.builder;

public class Sandwich {
    private String bread;
    private String size;
    private String topping;
    private String dressing;
    private String meat;

    public String getBread() {
        return bread;
    }

    public String getSize() {
        return size;
    }

    public String getTopping() {
        return topping;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }

    // Constructor
    private Sandwich(Builder builder) {
        this.bread = builder.bread;
        this.size = builder.size;
        this.topping = builder.topping;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }
    
    // Builder pattern
    public static class Builder {
        //Required params
        private String bread = "Frech bread";
        private String size = "XL";

        //Optional params - Initialite to default values
        private String topping = "lettuce";
        private String dressing = "ketchup";
        private String meat = "chicken";

        //Builder constructor with Required params
        public Builder(String bread, String size) {
            this.bread = bread;
            this.size = size;
        }

        public Sandwich buildSandwich() {
            return new Sandwich(this);
        }
//
//        public Builder bread(String bread) {
//            this.bread = bread;
//            return this;
//        }

        public Builder topping(String topping) {
            this.topping = topping;
            return this;
        }

        public Builder dressing(String dressing) {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat) {
            this.meat = meat;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + getBread() + '\'' +
                ", size='" + getSize() + '\'' +
                ", topping='" + getTopping() + '\'' +
                ", dressing='" + getDressing() + '\'' +
                ", meat='" + getMeat() + '\'' +
                '}';
    }
}
