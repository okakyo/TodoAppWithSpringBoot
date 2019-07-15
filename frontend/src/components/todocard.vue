<template lang="pug">
    v-card.todo
        v-card-title
            h2 タスク一覧
        v-divider
        div(v-if="cards.length==0")
            h3(style="text-align:center;padding:20px;") カードが存在しません。
        div(v-else)
            div(v-for="item in cards")
                v-layout(row,justify-center,full-height,align-center)
                    v-flex(xs2)
                    v-flex(xs7)
                        v-card-title
                            h3 タスク:
                                span  {{item.taskTitle}}
                        v-card-text
                            p 期限　：
                                span {{item.expiration}}
                            span 作成日：
                                span {{item.creation}}
                    v-flex(xs3)
                        v-btn(color="success")
                            b 編集
                        div(v-if="item.done" @click="checkDone(item)")
                            v-btn
                                b 完了
                        div(v-else)
                            v-btn(color="error" @click="checkDone(item)")
                                b 未完了
                v-divider


</template>



<script lang="ts">
    function setDatetime(date:any){
        return date.getFullYear()+"年"+date.getMonth()+"月"+1+date.getDay()+"日"
    }

    export default {
        name: "TODOCard",
        data() {
            return {
                cards:[
                    {
                        id:1,
                        taskTitle:"宿題",
                        expiration: setDatetime(new Date()),
                        creation: setDatetime(new Date()),
                        done: false
                    },
                    {
                        id:2,
                        taskTitle:"買い物",
                        expiration: setDatetime(new Date()),
                        creation: setDatetime(new Date()),
                        done: true
                    },
                ]
            }
        },
        methods:{
            checkDone:function (item) {
                item.done=!item.done;

            }
        }


    }
</script>

<style scoped>
    .todo{
        margin-top: 20px;
    }
</style>
