package org.docksidestage.bizfw.basic.buyticket;

// TODO done moriya クラスのJavaDocを入れておいてください by jflute (2026/10/23)

/**
 * The result of buying ticket at the booth, which has the bought ticket and the change.
 */
public class TicketBuyResult {
    private final Ticket ticket;
    private final int change;

    // #1on1: いいね、インスタンス変数の順序と、コンストラクターの順序が一致してて直感的でわかりやすい (2026/10/23)
    /**
     * Create the result of buying ticket.
     * @param ticket The bought ticket, which has not been used yet. (NotNull)
     * @param change The change for park guest, which is handed money minus ticket price. (NotNull)
     */
    public TicketBuyResult(Ticket ticket, int change) {
        this.ticket = ticket;
        this.change = change;
    }

    /**
     * Get the bought ticket.
     * @return The bought ticket, which has not been used at the time of buying. (NotNull)
     */
    public Ticket getTicket() {
        return ticket;
    }

    /**
     * Get the change returned to park guest.
     * @return The amount of change, zero if handed money is just the price. (Not Minus)
     */
    public int getChange() {
        return change;
    }
}
