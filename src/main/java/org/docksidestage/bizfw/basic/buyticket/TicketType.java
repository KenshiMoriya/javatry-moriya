package org.docksidestage.bizfw.basic.buyticket;

/**
 * The type of ticket sold at the booth, which determines the price and the days to enter park.
 */
public enum TicketType {
    ONE_DAY(7400, 1),
    TWO_DAY(13200, 2);

    private final int price;
    private final int days;

    TicketType(int price, int days) {
        this.price = price;
        this.days = days;
    }

    /**
     * Get the price of this ticket type, which is added to sales proceeds and written on ticket.
     * @return The price of ticket. (Not Minus)
     */
    public int getPrice() {
        return price;
    }

    /**
     * Get the days that the ticket of this type can be used to enter park.
     * @return The number of available days. (NotMinus, NotZero)
     */
    public int getDays() {
        return days;
    }
}
