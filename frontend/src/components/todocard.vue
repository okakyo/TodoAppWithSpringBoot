<template lang="pug">
    v-card.todo
        v-card-title
            h2 タスク一覧
        v-divider
        div
            v-layout(row,justify-center,full-height,align-center)
                v-flex(xs2)
                v-flex(xs6)
                    v-card-title
                        h2 タスク:
                    v-card-text
                        p 期限　：
                        p 作成日：
                v-flex(xs4)
                    v-btn(color="success")
                        b 編集
                    v-btn(color="error")
                        b 未完了

            v-divider
            v-layout(row,justify-center,full-height,align-center)
                v-flex(xs2)
                v-flex(xs6)
                    v-card-title
                        h2 タスク:
                    v-card-text
                        p 期限　：
                        p 作成日：
                v-flex(xs4)
                    v-btn(color="success")
                        b 編集
                    v-btn(color="error")
                        b 未完了
            v-divider


</template>

<script lang="ts">
    export default {
        name: "TODOCard"
    }
</script>

<style scoped>
    .todo{
        margin-top: 20px;
    }
</style>