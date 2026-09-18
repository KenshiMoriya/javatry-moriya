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
package org.docksidestage.javatry.basic;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? => over(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // ---補足---
    // supplySomething()の出力
    // log("in supply: {}", sea); -> in supply: over

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        String sea = functionSomething("mystic");
        consumeSomething(supplySomething());
        runnableSomething();
        log(sea); // your answer? => mysmys(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // String sea = functionSomething("mystic");　-> sea = mysmys
    // consumeSomething(supplySomething()); -> seaに影響なし
    // runnableSomething(); -> seaに影響なし
    // ---補足---
    // consumeSomething(supplySomething());
    // runnableSomething();
    // 完全に別のローカル変数を触っている

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys");
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over";
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic"));
    }

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904;
        boolean land = false;
        helloMutable(sea - 4, land, mutable);
        if (!land) {
            sea = sea + mutable.getStageName().length();
        }
        log(sea); // your answer? => 910
    }

    // ---誤答原因---
    // ---挙動の理解---
    // helloMutable(sea - 4, land, mutable); -> setterにより、stageName = "mystic"
    // if (!land) -> true
    // sea = sea + mutable.getStageName().length(); -> 904 + 6 = 910
    // ---補足---
    // St4MutableStageはsetterを持つmutableなクラス

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true;
        int sea = inParkCount;
        offAnnualPassport(hasAnnualPassport);
        for (int i = 0; i < 100; i++) {
            goToPark();
        }
        ++sea;
        sea = inParkCount;
        log(sea); // your answer? => 100(o)
    }

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) {
            ++inParkCount;
        }
    }

    // ---誤答原因---
    // ---挙動の理解---
    // offAnnualPassport(hasAnnualPassport); -> 引数のhasAnnualPassportをfalseにする（インスタンス変数に影響なし）
    // goToPark(); -> for文で ++inParkCount; を100回繰り返す（inParkCount = 100）
    // sea = inParkCount; -> sea = 100
    // ---補足---

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    private boolean availableLogging = true;

    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAwithB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCwithB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o quote(): has two arguments as String, returns first argument quoted by second argument (quotation) 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it separately)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAwithB(): 一つのString引数、引数の "A" を "B" に置き換えたStringを戻す 
     * o replaceCwithB(): 一つのString引数、引数の "C" を "B" に置き換えたStringを戻す 
     * o quote(): 二つのString引数、第一引数を第二引数(引用符)で囲ったものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも別途作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    public void test_method_making() {
        // use after making these methods
        String replaced = replaceCwithB(replaceAwithB("ABC"));
        String sea = quote(replaced, "'");
        if (isAvailableLogging()) {
            showSea(sea);
        }
    }

    // #1on1: いいね、メソッドの定義順が、呼び出し順序と一緒で直感的で把握しやすい (2026/09/18)
    // $普段から気をつけている、まとまりも意識
    // 多少、呼び出し順序を優先するか？まとまりを優先するか？悩むケースはあるけど...
    // 少なくとも、そこに気を遣って考えて配置するって習慣自体が大事。100点じゃなくていい。
    // (読み手に80点くらい読みやすいなと思ってもらえたらゴール)
    // 
    // write methods here
    private String replaceAwithB(String str) {
        return str.replace("A", "B");
    }

    private String replaceCwithB(String str) {
        return str.replace("C", "B");
    }

    // #1on1: いいね、第二引数の名前がわかりやすくて良い (2026/09/18)
    // 第一引数は、業務的な意味を持っていない引数なので、もうstrとかでいいでしょう。
    // 第二引数は、業務的な意味を持っているので、その業務を示す言葉あると良い。
    // 引数名ってすごく大事、普通のローカル変数よりも大事。
    // というのは、引数は呼び出し側へのインターフェースでもあるから。
    private String quote(String str, String quote) {
        return quote + str + quote;
    }

    private boolean isAvailableLogging() {
        return availableLogging;
    }

    private void showSea(String str) {
        log(str);
    }

    // ---誤答原因---
    // ---挙動の理解---
    // replaceCwithB(replaceAwithB("ABC")) // ABC -> BBC -> BBB
    // quote(replaced, "'") // BBB -> 'BBB'
    // 実行結果 : 'BBB'
    // ---補足---

    // #1on1: 一番下に追加される問題 (2026/09/18)
    // 最初に書いた人が綺麗でも、その後、通りすがった人がどんどんゴミを捨てていく。
    // $タグコメントがある程度の強制力になってる？
    // Good, ありがとう。その意味合いもあって、現場で採用しているところもある。
    // コード(クラス内の変数やメソッド)の業務カテゴリと階層構造を意識してもらいたい。
    //
    // 既存クラスを修正するとき、既存の「コード体裁デザイン」を把握して修正して欲しい。
    // おじゃまします感。既存コードに対する責任は、今修正しようとしている人が持っている。
    // なので、既存の「コード体裁デザイン」に対する責任も、今修正しようとしている人が持つ。
    //private void land() {
    //}
}
