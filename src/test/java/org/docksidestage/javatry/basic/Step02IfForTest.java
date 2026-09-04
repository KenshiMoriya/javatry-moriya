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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author KenshiMoriya
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // if (sea > 904) -> False
    // else文で sea = 7 になる
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // プログラムは上から実行される
    // else if (sea >= 904) -> True
    // よって sea = 7 になる
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
            sea = sea++ * 2;
        } else if (land && sea >= 904) {
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {
            if (sea % 2 == 0) {
                sea = sea++ * 2; // 1810(x) → 1808(o)
            }
            if (!land) {
                land = true; // 当たり: ここを通ったらseaが10
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) { // falseだと思ってたらtrue
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--; // 1810だと思ってたとしても、ここで1809になると思うはず
            if (sea % 2 == 1) { // trueと思っちゃったかも → trueでOK
                sea++; // 1810に戻った想定
            }
        }
        if (land) { // ここを見逃しちゃった？
            sea = 10; // 疲れてた？
        }
        log(sea); // your answer? => 1810(x) -> 10
    }
    // #1on1: アドバイス: 漠然読みして構造把握してから読む (2026/08/21)
    // ここだと、変数宣言、でかif, 中if, 小if, ログの5つのレイヤーがある。
    // 頭の中で地図を作った状態で読み進めていけば、ifの見逃しとかも少なくなるかも。

    // #1on1: 漠然読みからフォーカス読み (2026/08/21)
    // o 漠然読みして構造把握 (全体像を見る)
    // o 目的に沿って当たり(ギャンブルポイント)を見つける
    // o 当たりからフォーカス読みをする (逆さ読みも取り入れながら)
    //
    // $構造把握は意識していたが、フォーカス読みは新鮮。
    //
    // 意識の反復練習で何度もやっていって、当たりを見つけるスキルを高めていく。
    // 
    // ギャンブルに負けることもある。
    // でも、損はない。構造把握もしてるし、landのライフサイクルも知ってるので...
    // 0の状態から網羅読みするよりも速く網羅読みできるようになっているはず。
    //
    // 一方で、踏み込んだ分、次の当たりが見つかることも多い。
    // なのでまたフォーカス読みを繰り返して3,4回やったとしても、
    // 網羅読みするよりも速い可能性も高い。
    //
    // 仮説思考的なコードリーディング!?とも言えるかも。
    // done moriya [読み物課題] My Favorite Book: 仮説思考 by jflute (2026/08/21)
    // https://jflute.hatenadiary.jp/entry/20150111/kasetsu
    // "論理によるアウトプットと感覚によるアウトプットの意識化"
    // #1on1: 論理と感覚のコラボレーションでスキルアップ話 (2026/09/04)

    // ---誤答原因---
    // sea = sea++ でseaは変化しない
    // #1on1: ↑これは誤答の誤答の原因。間違うにしても1810じゃなく8だった (2026/08/21)
    // 本当の誤答原因は、landのifの見逃し。
    // ---挙動の理解---
    // else if (sea >= 903 || land) -> True
    // if (sea % 2 == 0) -> True
    // sea = sea++ * 2; で sea = 1808
    // if (!land) -> True
    // land = true;
    // if (sea < 1810) -> True
    // sea = 9; // ？？？ ここを通ったと思った？ (実際は通ってない)
    // if (sea >= 9 || (sea > 7 && sea < 9)) -> True
    // sea--; で sea = 8
    // if (land) -> True
    // sea = 10;
    // ---補足---
    // x = x++ は x = x (Javaの挙動)
    // 1. 格納先 = ローカル変数 x
    // 2. 右辺 x++ を評価 -> 式の値は 904、xが 905 になる
    // 3. 格納先に 904 を書き込む <- 905 を上書き
    //
    // #1on1: 伝統的なJavaのややこしい挙動 (2026/08/21)
    // へー、くらいな感じで頭の片隅においておくくらいでOKで、
    // 実際、インクリメントは、基本独立行で書くのが一般的に習慣化してる。
    // 
    // よもやま: 言語の互換性のコンセプト (2026/08/21)
    // 互換性キープ寄り: Java // ここ最近は少し進化を重視して若干の互換崩しもある
    // 進化を重視よりの言語もある。

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // for文で i = 1 のとき
    // String stage = stageList.get(1); // stage = dockside
    // sea = stage; // sea = dockside
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage;
        }
        log(sea); // your answer? => magiclamp(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // for (String stage : stageList) で要素数分ループ
    // stage = broadway (最初)
    // stage = dockside
    // stage = hangar
    // stage = magiclamp (最後)
    // ---補足---
    // Javaのシュガーシンタックス(イテレータ)
    // for (String stage : stageList)

    // #1on1: Javaの文法としてのループ二つ (2026/09/04)
    // o intあいのfor文: Java当初から (1995年) // 伝統的なfor文
    // o 拡張for文(foreach文): Java10年目くらいから (2005年くらい) // 普通のfor文
    // 
    // 単純なシュガーシンタックスというわけでもないという話。
    // そうです、イテレータです。
    // 
    // intあいのfor文は毎ループ探しに行っているので、Listの内容によっては遅い。
    // (ArrayListは速いけど、LinkedListは遅いかも)
    // 拡張for文はイテレータなので、どっちでもわりと速そう。
    // と言う感じで仕組みが違うので、パフォーマンス的な特徴が変わってくる。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // your answer? => hangar(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // for (String stage : stageList) で要素数分ループ
    // stage = "hangar" のとき
    // sea = "hangar";
    // if (stage.contains("ga") -> True
    // break; でループ終了
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // stageList.forEach(stage -> {}) で要素数分ループ
    // stage = "dockside" のとき
    // if (stage.contains("i")) -> True
    // sb.append("dockside"); で sb = "dockside"
    // if (sb.length() > 0) -> True
    // return でループ終了
    // String sea = sb.toString(); で sea = "dockside"
    // ---補足---
    //

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
        List<String> stageList = prepareStageList();
        List<String> containsAList = new ArrayList<>();
        for (String stage : stageList) {
            if (stage.contains("a")) {
                containsAList.add(stage);
            }
        }
        for (String stage : containsAList) {
            log(stage);
        }
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        //        List<String> stageList = prepareStageList();
        //        String sea = null;
        //        for (String stage : stageList) {
        //            if (stage.startsWith("br")) {
        //                continue;
        //            }
        //        sea = stage;
        //        if (stage.contains("ga")) {
        //            break;
        //        }
        //        }
        //        log(sea); // should be same as before-fix
        List<String> stageList = prepareStageList();
        String[] result = new String[1];
        boolean[] found = new boolean[1];
        // ここはは、test_メソッドの管轄下であるが...
        stageList.forEach(stage -> {
            // ここは、test_メソッドの管轄下ではない
            // Lambda式が表現する別クラス別メソッドの管轄下
            if (found[0]) {
                return;
            }
            if (stage.startsWith("br")) {
                return;
            }
            result[0] = stage;
            if (stage.contains("ga")) {
                found[0] = true;
            }
        });
        String sea = result[0];
        log(sea); // should be same as before-fix

        // #1on1: なんで外側のローカル変数の再代入ができないのか？ (2026/09/04)
        // forEach()メソッドのコードを読んでみた。
        // ただのメソッド、for文の代理人みたいな。
        // step8の先取り、-> { はLambda式で、実装クラスの定義とnewのシュガーシンタックスみたいもの。
        // ここだと、1ループの処理を表現するクラスをその場で定義してその場でnewしてる。
        // for文とは、statementの管轄が全然違う。
        // 別のローカルなので、ローカル変数のコンセプトからしたら、
        // 別クラス別メソッドに、自分のローカル変数を書き換えられたらたまらん(カオス)。
        // ただ、(finalなら)参照だけはOKになってて、参照だけならコピーで済むので、副作用も起きないから大丈夫。
        //
        // continue;break;ができない理由も、つながってくる。
        // -> {} は、for文直下ではなく、別クラス別メソッドなので、(文法的に)ループから呼ばれるとは限らない。

        // #1on1: forEach()メソッドの存在意義って？ (2026/09/04)
        // forEach()メソッド: 拡張for文から10年くらい経って登場 (2015年くらい)
        // 存在意義がなければ登場しない。
        // 拡張for文に比べて何が良いのか？
        //
        // 拡張for文: 外側のローカル変数の再代入できる、continue;break;できる
        // forEach()メソッド: ↑できない、↑できない
        //
        // $制約が活かされる？immutable/mutableと同じ？
        // yes, 素晴らしい。
        // 安全性、可読性、ストレートなループだったらforEach()メソッドの方が向く。
        // webサービスだと、そういうループの方が圧倒的に多い。
        // (フレームワークとかだとまた変わってくるけど)
        // ということで、適材適所的なループ提供になっている。
        //
        // (ループから飛躍して、制限デザインの話)
        // よもやま: 一方で、適材適所すぎるのもつらいという考え方も。
        // 使い分けの判断コストという側面もある。
        // 選択肢が多すぎると、人間そのコストが高くなってくる。(例えば7,8種類もあったりすると)
        // 永遠のジレンマ。
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
