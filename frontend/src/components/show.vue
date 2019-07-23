<template lang="pug">
    v-card.todo
        v-card-title
            h2 タスク一覧
        v-divider
        div(v-if="tasks.length==0")
            h3(style="text-align:center;padding:20px;") カードが存在しません。
        div(v-else)
            div(v-for="item in tasks", v-bind="item.id")
                v-layout(row,justify-center,full-height,align-center)
                    v-flex(xs2)
                    v-flex(xs7)
                        v-card-title
                            h3 タスク:
                                span  {{item.title}}
                        v-card-text
                            p 期限　：
                                span {{item.expiration | setDatetime}}
                            span 作成日：
                                span {{item.createdAt | setDatetime}}
                    v-flex(xs3)
                        v-btn(color="success" :to="{name:'detail',params:{id:item.id}}")
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


    export default {
        name: "TODOCard",
        data(){
            return {
                newTask:{}
            }
        },
        filters: {
            setDatetime:(date:any)=>{
                date=new Date(date);
                return date.getFullYear()+"年"+(date.getMonth()+1)+"月"+1+date.getDay()+"日"
            },
        },
        async created(){
            await this.$store.dispatch('getTodo');

        },
        computed:{
            tasks(){
                return this.$store.getters.getData.filter(item=>!item.done);
            },


        },

        methods:{
            async checkDone(item){
                item.done=!item.done;
                await this.$store.dispatch('postTodo',item)
            }

        }

    }
</script>

<style scoped>
    .todo{
        margin-top: 20px;
    }
</style>
