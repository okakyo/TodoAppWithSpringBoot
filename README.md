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
        - BackEnd: 
- ## 環境構築方法:
    - `docker-compose build` で環境構築が開始されます。
- ## 起動方法:
    - `sh serve.sh` でサーバーを実行することができます。

- ## 課題点
    - Vue.js を　`npm run build` で
