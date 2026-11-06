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
public class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // #1on1: いいね、remainingDays, とても直感的でわかりやすい (2026/11/06)
    private final TicketType ticketType;
    private final int displayPrice; // written on ticket, park guest can watch this
    private int remainingDays; // 0 means this ticket is unavailable

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(TicketType ticketType) {
        this.ticketType = ticketType;
        this.displayPrice = ticketType.getPrice();
        this.remainingDays = ticketType.getDays();
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    public void doInPark() {
        if (remainingDays <= 0) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        --remainingDays;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public TicketType getTicketType() {
        return ticketType;
    }

    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    // #1on1: いいね、互換性のために残している良い。 (2026/11/06)
    // 実際の現場だと、修正仕切っちゃうか、互換性のために残すか、選択肢はあるけど。
    // deprecated運用の紹介。
    public boolean isAlreadyIn() {
        // #1on1: 実装見ると、1日でも入るとtrueになる仕様 (2026/11/06)
        // それで良かった？
        // 呼び出し側が「使い切ってるかどうか？」のつもりで呼び出してたらデグレになる。
        // alreadyInの変数のコメントで、unavailableという言葉があったので、
        // 一応使い切ってるかどうか？のニュアンスで作られていた。
        //
        // 新機能による既存概念の崩れに気づけるか？
        // こういったものづくりスキルに注目してもらいたい。
        //
        // $test_class_moreFix_usePluralDays()の方では使い切りのニュアンスで自分で実装してる
        // それも素晴らしい体験の一つ。失敗の思い出をたくさん作るのが大事。
        // TODO moriya 内容も互換性キープ by jflute (2026/11/06)
        return remainingDays < ticketType.getDays();
    }
}
