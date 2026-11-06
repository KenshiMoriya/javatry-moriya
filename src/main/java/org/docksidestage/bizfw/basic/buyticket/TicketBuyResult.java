package org.docksidestage.bizfw.basic.buyticket;

// done moriya クラスのJavaDocを入れておいてください by jflute (2026/10/23)

// TODO moriya @authorも入れておいてください by jflute (2026/11/06)
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

    // #1on1: getterのjavadocの冗長じれんまについて (2026/11/06)
    // jfluteだと、概要説明を省略したりする。
    // TODO moriya 冗長の解決、抽象度を変えて工夫してもいいし、概要説明を削除でもいいし by jflute (2026/11/06)
    /**
     * Get the bought ticket.
     * @return The bought ticket, which has not been used at the time of buying. (NotNull)
     */
    public Ticket getTicket() {
        return ticket;
    }
    // #1on1: いいね、NotNull, NullAllowed, NotMinusの表現Good (2026/11/06)
    // LastaFluteのコードの例も見てみた。Javaだとあるととても嬉しい。
    // (at showbaseとかお遊びのコメントの話も)
    // LocalDateのplus()の例、Java標準でもやっているところはある。
    
    // #1on1: いいね、こっちは抽象度を変えた表現になっていてどちらも価値のあるコメントになってる (2026/11/06)
    /**
     * Get the change returned to park guest.
     * @return The amount of change, zero if handed money is just the price. (Not Minus)
     */
    public int getChange() {
        return change;
    }
}
