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

import java.math.BigDecimal;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author KenshiMoriya
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log(sea); // your answer? => mystic
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;
        log(sea); // your answer? => mystic8:mai(x) => mystic8null:mai
    }
    // ---誤答原因---
    // Stringのnullは文字列連結（+で連結）すると文字列"null"に変換される
    // ---挙動の理解---
    // String a = null; の形でnull初期化することは問題ないが、null変数に対してメソッドを呼び出すと、実行時にNullPointerException（NPE）が発生する
    // しかし、例外的に文字列連結・==による比較・静的メソッドに渡す場合は問題ない
    // ---補足---
    // Javaの基本型（プリミティブ型）はbyte, short, int, long, float, double, char, booleanの８つ
    // 文字列はStringクラス（参照型、オブジェクト）として提供される
    // Stringはimmutable -> 一度作ったStringの中身は変更できない -> 連結などでは新しいオブジェクトが作られる
    // done moriya [いいね] カテゴリごとにメモが書かれていてわかりやすいですね^^ by jflute (2026/07/23)
    // NullPointerのことまで学ばれていて素晴らしいです。null変数の連結は例外にならないんですよね。
    // #1on1: 他の言語だと？ (2026/07/23)
    // C#だと、空文字になるので、Javaとは違う。でも例外にならないことは同じ。
    // ちなみに、SQLだと sea + land + piari... → null (確かに)
    // プログラミング言語の決めの問題。
    // nullのメール文言の例。画面とメールの気合いの入れ方の違い。
    // "null" って表示されるメリデメ:
    // デメリット: 画面やメールでnullって出やすくて体裁が悪い
    // メリット: (開発時)nullって出てわかりやすい by もりやさん
    // 些細な違いでも、必ずメリデメはあるので、それを分析する習慣が大事。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic"; // 1丁目1番地
        String land = "oneman"; // 2丁目2番地
        sea = land; // どっちも2丁目2番地を指す
        land = land + "'s dreams"; // 3丁目3番地(中間成果物インスタンス), 4丁目4番地
        log(sea); // your answer? => oneman(o)
    }
    // ---誤答原因---
    // ---挙動の理解---
    // sea = landの処理後にland(String)を書き換えているためseaには影響しない
    // ---補足---
    // done moriya [いいね] アドレスのコピーをしているだけですから、seaの参照先には影響ないわけです by jflute (2026/07/23)
    // #1on1: 変数のアドレスの話 (2026/07/23)
    // C言語でやってるのでイメージはOKそう。
    // 変数とインスタンスは、1:1ではなく、many-to-oneになりうる。
    // #1on1: インスタンスとは？ (2026/07/23)
    // 一軒家の例、設計図(クラス)とインスタンスの関係性。
    // 変数とインスタンスの関係性。
    // BigDecimalインスタンス何個あるエクササイズ。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415(o)
    }
    // ---誤答原因---
    // ---挙動の理解---
    // sea = landの処理後にland(int)をインクリメントしているためseaには影響しない
    // ---補足---
    // #1on1: プリミティヴ型の紹介。 (2026/07/23)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94); // 1
        BigDecimal land = new BigDecimal(415); // 2
        sea = land; // 3 → x
        sea = land.add(new BigDecimal(1)); // 4,5 → 3,4
        sea.add(new BigDecimal(1)); // 6,7 → 5,6 (合計6インスタンス)
        log(sea); // your answer? => 417(x) => 416
    }

    // ---誤答原因---
    // sea.add(...)のように返り値を受け取らない演算は無意味となる
    // ---挙動の理解---
    // sea = land;は値のコピーではなく参照の付け替え
    // BigDecimalはimmutable
    // -> sea.add(new BigDecimal(1));の行は返り値を変数に代入していないため無意味
    // ---補足---
    // BigDecimalは任意制度で正確な10進数（小数）を扱うためのクラス（java.mathに含まれる）
    // double, floatでは内部的に2進数のため、10進数の小数を正確に表せない
    // done jflute 1on1にて、immutableのお話をじっくり (2026/07/23)
    // #1on1: immutable/mutable (2026/07/23)
    // コーディングではけっこう聞いたことある。
    // immutableとは？ (不変な)
    // o immutableなインスタンス(クラス) (デフォルト) → BigDecimal
    // o immutableな変数
    // 
    // #1on1 immutableのメリデメ (2026/07/23)
    // immutableメリット: 決まった値など、変わってないことを保証したい
    // 変わってないことを保証されると... → 可読性、安全性
    // #1on1: 後半エクササイズで、immutable引数でメソッドのコードの読み飛ばしを説明 (2026/08/03)
    //
    // #1on1: immutableデメリット: (2026/08/03) 
    // (by もりやさん)
    // 1. パフォーマンス、つどつどnewする、インスタンス多すぎ
    // 2. 戻り値の受け取り忘れがバグになる
    // 3. add()の繰り返しの処理など、mutableの方が書くの世話ない (1とも絡むけど)
    // → immutableは若干コーディングで手間を掛ける、意識して実装する必要がある
    // → 徹底してimmutableに統一しようとすると、言語の高度な文法が欲しくなる
    //
    // よもやま: シュガーシンタックス (糖衣構文)
    // 
    // #1on1: immutableの歴史 (2026/08/03)
    // o 昔のPCは、メモリが貧弱だった
    // o インフラが発展して、PC都合のデメリットは薄くなって、人間都合のメリットを享受したいとなった
    //
    // #1on1: immutableのバランス (2026/08/03)
    // immutable, どこまで徹底するか？
    // o Javaだと、100%immutableはなかなか難しいので、(感覚値)8:2でimmutable/mutableみたいな感じ!? (2026/08/03)
    //   (歴史的にも昔のクラスはmutableだし、文法もそこまでimmutable全推しじゃない印象)
    //   → jfluteも、8:2感覚で、mutableで割り切る時は、mutableのデメリットが発生しないような工夫をする。
    //     安全性と可読性の演出手段は、immutableだけじゃない。別の手段でも演出できるので、それを使って工夫する。
    // o 他の言語だと、100%を目指す文化もあったりする。
    //   (言語自体が目指しているか？いないか？)

    // done jflute 次回デメリットから再開 (2026/07/23)

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // isntanceBroadwayはインスタンス変数
    // -> インスタンス変数は自動でデフォルト値が入る
    // -> Stringのデフォルトはnull
    // -> log(sea);でnullが出力される
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // instanceDocksideはインスタンス変数
    // -> インスタンス変数は自動でデフォルト値が入る
    // -> intのデフォルトは0
    // -> log(sea);で0が出力される
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => null(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // instanceHangarはインスタンス変数
    // -> インスタンス変数は自動でデフォルト値が入る
    // -> Integerのデフォルトはnull
    // -> log(sea);でnullが出力される
    // ---補足---

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => bigband|1|null|magician(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // instanceBroadway
    // 同名のローカル変数も引数もない -> this.instanceBroadwayへの代入
    // instanceDockside
    // 同名のローカル変数も引数もない -> this.instanceDocksideへのインクリメント
    // instanceMagiclanmp
    // 引数が同名のフィールドを隠す（shadowing）-> フィールドは変わらない
    // ---補足---
    // フィールドを触りたい場合
    // this.insanceMagiclampと書く
    // done moriya [いいね] yes, shadowing が発生していますね。 by jflute (2026/08/03)
    // 同じ名前だからと言って、同じ変数とは限らないということで。
    // また、メソッドを呼び出して引数を渡すというのは、変数という箱自体が相手に渡るわけではなく、
    // 中身だけが渡るというイメージで。厳密にはオブジェクト型ならアドレスが伝達されるだけ。

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // ++land;
    // primitiveなので呼び出し元のlandは415
    // sea.concat(landStr);
    // Stringはimmutableなので、concatは新しいStringを作るが、戻り値がないため受け取られない
    // ---補足---
    // 生成されたharbor416は、GC対象になる
    // done moriya [ふぉろー] 引数がimmutableであれば、helpを読まなくても結果がわかってしまいます by jflute (2026/08/03)
    // #1on1: help読まないことで、読み飛ばしができる (2026/08/03)
    // 逆に、変えないのにmutableなクラスで受け取ってると、読み飛ばしができなくて読み手が大変。

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => harbor416(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // StringBuilderはmutable
    // appendは自分自身の内部バッファを書き換える（新しいオブジェクトを作らない）
    // ---補足---
    // String#concat -> 新しいオブジェクトを返す
    // StringBuilder#append -> 自分を書き換えて自分を返す。
    // done moriya [よだん] せっかくなので、1on1で内部バッファを書き換えるコード読んでみたいですね^^ by jflute (2026/08/03)
    // #1on1: char[]のvalueを別のメソッドに渡して、中身を上書きしていた (2026/08/03)

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => harbor(o)
    }

    // ---誤答原因---
    // ---挙動の理解---
    // 元のオブジェクトは書き変わっていない
    // 1. sea.toString() -> 変更なし
    // 2. new StringBuilder(seaStr) -> 新しいオブジェクト生成
    // 3. append(sea) -> 新オブジェクトが書き換わる"harbor416"
    // 4. 引数のseaに代入
    // ---補足---
    // メソッド内のseaはメソッドを抜けたら誰も参照しない（IDEで確認）
    // done moriya [いいね] append()が呼ばれたインスタンスが別物ということですね by jflute (2026/08/03)
    // #1on1: ちょこっと、DBFluteのAbstractSqlClauseのコード読んでみた (2026/08/03)

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    private int piari;

    public void test_variable_writing() {
        // define variables here
        String sea = "mystic";
        Integer land = null;
        String answer = sea + "," + land + "," + piari;
        log(answer);
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        // write your code here
    }
}
