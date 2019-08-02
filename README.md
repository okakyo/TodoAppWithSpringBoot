# Todo アプリ　

- ## 使用した技術
    - DB: 
        - MySQL (port: 3306)
            - username: root
            - password: OkaKyo1997
            
    - Frontend: (port:8080) 
        - Vue.js(TypeScript)
        - Vuex
        
        - Vuetify
    - Backend ： (port: 5050)  
        - Spring Boot(REST API) 

- ## 設計ポイント:
    - ### データベース(Todoテーブル)：
        - id: Int型
        - expiration : Date型
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
            
## 動作確認
- Docker　を使わない場合での環境構築
   1. あらかじめ、PC に以下のものをDLしておく。
   - git
   - nodejs
   - intelliJ
   2. `git clone https://github.com/okakyo/TodoAppWithSpringBoot.git` でDLしたのち,
      このファイルをintelliJ で起動
   3. intelliJ にて、このコードを実行する。
   4. frontend のディレクトリへ移動。
   5. ターミナル上で、`npm install && npm install -g vue@cli` を実行
   6. ターミナル上で、`npm run serve`　を実行する.
   
- Docker を使う場合での環境構築（未完成）
    1. ``git clone https://github.com/okakyo/TodoAppWithSpringBoot.git `` をターミナルじょうで実行
    2. `cd TodoAppWithSpringBoot` にてディレクトリへ移動したのち、`docker-compose build`　を実行
    3. ビルドが完了したら、` docker-compose up -d` をしたのち、`sh server.sh`　で フロントエンドのコンテナに入り、
       `npm run serve`を実行する。
       
 ## 課題点、反省点
- Docker　によるローカル環境の構築がうまくいかなかった.

-  SpringBoot を gradle でコンパイルすると,起動時に次のエラーが発生する点がまだ解決していない。


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

- コンポーネント設計に基づいて、フロントエンドの画面を形成するファイルをまとめるような設計をすればよかった。
