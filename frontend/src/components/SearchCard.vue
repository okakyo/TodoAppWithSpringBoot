<template lang="pug">
    v-card
        v-card-title
            h2 未完了タスクの検索
        v-divider
        v-card-text
            v-layout
                v-flex(xs2)
                v-flex(xs6)
                    v-form
                        v-text-field(v-model="title",
                        prepend-icon="search"
                        label="タスク",
                        name="title",
                        ref="title",
                        required)

        div(v-if="tasks.length==0")
            h3(style="text-align:center;padding:20px;") カードが見つかりませんでした。
        div(v-else)
            h2(style="padding:20px;") {{length}}件見つかりました
            v-divider
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
        name: "SearchCard",
        data(){
            return {
                title:"",
                length:0
            }
        },
        filters: {
            setDatetime:(date:any)=>{
                date=new Date(date);
                return date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日"
            },
        },
        async created(){
            let self:any=this;
            await self.$store.dispatch('getTodo');
        },
        computed:{
            tasks():any{
                let self:any=this;
                const response=self.$store.getters.getData.filter((item:any)=>(!item.done && item.title.includes(self.title)));
                self.length=response.length;
                return response;
            },


        },

        methods:{
            async checkDone(item:any){
                let self:any=this;
                item.done=!item.done;
                await self.$store.dispatch('postTodo',item)
            }
        }

    }
</script>

<style scoped>

</style>
