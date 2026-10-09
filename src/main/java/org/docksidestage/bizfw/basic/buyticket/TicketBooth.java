/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // you can rewrite comments for your own language by jflute
    // e.g. Japanese
    // /**
    // * 1Dayパスポートを買う、パークゲスト用のメソッド。
    // * @param handedMoney パークゲストから手渡しされたお金(金額) (NotNull, NotMinus)
    // * @throws TicketSoldOutException ブース内のチケットが売り切れだったら
    // * @throws TicketShortMoneyException 買うのに金額が足りなかったら
    // */
    // TODO moriya いま、戻り値があるので、JavaDocでも戻り値の説明を入れましょう by jflute (2026/10/09)
    // (ちなみに、日本語でOK)
    // TODO moriya privateメソッドの方が、publicより下がJavaの慣習 by jflute (2026/10/09)
    // TODO moriya publicとprivateでメソッド名の先頭を区別する慣習もある by jflute (2026/10/09)
    // 些細ではあるけれども、コード上と会話上で区別しやすいように、工夫することがある。
    // e.g. doBuyPassport(), internalBuyPassport(), ...
    // よかったら、renameのリファクタリングを、1,2秒でやってみてください。
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    private int buyPassport(Integer handedMoney, int price) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        // TODO moriya 引数でpriceを受け取って抽象化してるのに、ONE_DAY残っちゃってる by jflute (2026/10/09)
        // #1on1: 再利用しようする過程の中のコピペの修正ミス (2026/10/09)
        // めんどうでも一括置換/検索確認のススメ。というかめんどうじゃないような環境づくりをしておく。
        // (jkcode.txt, jkerror.txt のよもやま話)
        // よもやま: 指のお話、手間が掛からないからこそやろうと思うことがある。
        if (handedMoney < ONE_DAY_PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        --quantity;
        if (salesProceeds != null) { // second or more purchase
            salesProceeds = salesProceeds + price;
        } else { // first purchase
            salesProceeds = price;
        }
        return handedMoney - price;
    }

    public void buyOneDayPassport(Integer handedMoney) {
        buyPassport(handedMoney, ONE_DAY_PRICE);
    }

    public int buyTwoDayPassport(Integer handedMoney) {
        return buyPassport(handedMoney, TWO_DAY_PRICE);
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
