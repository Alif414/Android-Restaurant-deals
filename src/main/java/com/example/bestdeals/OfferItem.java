package com.example.bestdeals;

public class OfferItem {
    private int iconPic;
    private int restPic;
    private String name;
    private String location;
    private String details;
    private String deals;
    private String period;
    private String price;
    private String discPrice;

    public OfferItem(int iconPic, int restPic, String name, String location, String details, String deals, String period, String price, String discPrice) {
        this.iconPic = iconPic;
        this.restPic = restPic;
        this.name = name;
        this.location = location;
        this.details = details;
        this.deals = deals;
        this.period = period;
        this.price = price;
        this.discPrice = discPrice;
    }

    public String getName() {
        return name;
    }

    public int getIconPic() {
        return iconPic;
    }

    public int getRestPic() {
        return restPic;
    }

    public String getLocation() {
        return location;
    }

    public String getDetails() {
        return details;
    }

    public String getDeals() { return deals; }

    public String getPeriod() {
        return period;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscPrice() {
        return discPrice;
    }
}
