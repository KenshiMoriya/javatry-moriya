package org.docksidestage.bizfw.basic.buyticket;

// TODO moriya クラスのJavaDocを入れておいてください by jflute (2026/10/23)
public class TicketBuyResult {
    private final Ticket ticket;
    private final int change;

    // #1on1: いいね、インスタンス変数の順序と、コンストラクターの順序が一致してて直感的でわかりやすい (2026/10/23)
    public TicketBuyResult(Ticket ticket, int change) {
        this.ticket = ticket;
        this.change = change;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return change;
    }
}
