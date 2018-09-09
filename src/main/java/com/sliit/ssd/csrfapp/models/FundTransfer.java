package com.sliit.ssd.csrfapp.models;

/**
 * Represents a fund transfer entity
 *
 * Created by dinukshakandasamanage on 9/6/18.
 */
public class FundTransfer {

    private String to;
    private String from;
    private String amount;
    private String csrf;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCsrf() {
        return csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundTransfer that = (FundTransfer) o;

        if (to != null ? !to.equals(that.to) : that.to != null) return false;
        if (from != null ? !from.equals(that.from) : that.from != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        return csrf != null ? csrf.equals(that.csrf) : that.csrf == null;
    }

    @Override
    public int hashCode() {
        int result = to != null ? to.hashCode() : 0;
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (csrf != null ? csrf.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FundTransfer{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", amount=" + amount +
                ", csrf='" + csrf + '\'' +
                '}';
    }
}
