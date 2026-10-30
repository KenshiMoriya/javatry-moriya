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

    public boolean isAlreadyIn() {
        return remainingDays < ticketType.getDays();
    }
}
