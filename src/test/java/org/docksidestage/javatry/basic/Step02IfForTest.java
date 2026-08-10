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
 * @author your_name_here
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
                sea = sea++ * 2;
            }
            if (!land) {
                land = true;
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--;
            if (sea % 2 == 1) {
                sea++;
            }
        }
        if (land) {
            sea = 10;
        }
        log(sea); // your answer? => 1810(x) -> 10
    }

    // ---誤答原因---
    // sea = sea++ でseaは変化しない
    // ---挙動の理解---
    // else if (sea >= 903 || land) -> True
    // if (sea % 2 == 0) -> True
    // sea = sea++ * 2; で sea = 1808
    // if (!land) -> True
    // land = true;
    // if (sea < 1810) -> True
    // sea = 9;
    // if (sea >= 9 || (sea > 7 && sea < 9)) -> True
    // sea--; で sea = 8
    // if (land) -> True
    // sea = 10;
    // ---補足---
    // x = x++ は x = x (Javaの挙動)
    // 1. 格納先 = ローカル変数 x
    // 2. 右辺 x++ を評価 -> 式の値は 904、xが 905 になる
    // 3. 格納先に 904 を書き込む <- 905 を上書き

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
        stageList.forEach(stage -> {
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
