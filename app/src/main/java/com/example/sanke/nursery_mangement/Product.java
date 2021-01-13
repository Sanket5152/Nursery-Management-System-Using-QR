package com.example.sanke.nursery_mangement;

public class Product {
    private int pid;
    private String pname;
    private String pbname;
    private String ppart;
    private String pmedi;
    private String pfamily;
    private double pprice;
    private String image;

    public Product(int pid, String pname, String pbname, String pfamily, String ppart, String pmedi, double pprice, String image) {
        this.pid = pid;
        this.pname = pname;
        this.pbname = pbname;
        this.pfamily = pfamily;
        this.pprice = pprice;
        this.ppart=ppart;
        this.pmedi=pmedi;
        this.image = image;

    }

    public int getPid() {
        return pid;
    }

    public String getpname() {
        return pname;
    }

    public String getPbname() {
        return pbname;
    }
    public String getPfamily() {
        return pfamily;
    }

    public String getPmedi() {
        return pmedi;
    }

    public String getPpart() {
        return ppart;
    }



    public double getpprice() {
        return pprice;
    }

    public String getImage() {
        return image;
    }
}