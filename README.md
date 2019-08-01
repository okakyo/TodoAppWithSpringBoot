# Todo アプリ（SpringBoot）

- ## 使用した技術
    - DB: MySQL
    - Frontend: 
        - Vue.js(TypeScript)
        - Vuex
        - Vuetify
    - Backend ：Spring Boot(REST API)

- ## 設計ポイント:
    - ### データベース(Todoテーブル)：
        - id: Int型
        - title: String型 (max-length=50)
        - done: Boolean型 (default=false)
        - createdAt: Date型
        - updatedAt: Date型
    
    - ### 設計、構成について
        - FrontEnd: 
            - src:
                - assets: 画像ファイルを保存するためのファイル
                - components:
                    - フロントエンドの画面をコンポーネント単位で分割したものファイル
                - plugin:
                    - Vuetify を利用できるようにするためのファイル
                - views:    
                    各 URLごとの画面（ページ要素）を保存するためのファイル
                - その他(一部のファイルについての説明)
                    - main.ts: Vueを起動するための拡張子
                    - router.ts: フロントエンドのルーティングを操作するファイル
                    - store.ts: Vue におけるVuex を操作するためのファイル
        - src(Backend):
            - main:
                 - java: 
                    -Todo: バックエンドのAPIの設定について書いたコード
                        - Application.java: 
                        - MainConfiguration.java:
                        - MainModel.java: 
                        - Repository.java:
                        - MainService.java:
                        - RESTController.java:
                 - resources
                    - application  
            
- ## 環境構築方法
    - `docker-compose build` で環境構築が開始されます。
- ## 起動方法:
    - `sh serve.sh` でサーバーを実行することができます。

- ## 課題点
-  SpringBootをgradle でコンパイルすると,起動時に次のエラーが発生する。


```bash

okakyouheinoMacBook-Pro:zip okakyouhei$ gradle build
> Task :compileJava FAILED

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileJava'.
> Could not resolve all files for configuration ':compileClasspath'.
   > Could not find org.springframework.boot:spring-boot-gradle-plugin:.
     Required by:
         project :

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 1s
1 actionable task: 1 executed

```

- `npm run build` してコンパイルされたindex.htmlを、SpringBootのサーバー で表示できなかった。


