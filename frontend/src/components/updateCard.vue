<template lang="pug">
    v-card
        v-card-title
            h2 Todoの内容を変更します.
        v-divider
        v-card-text
            v-form(ref="form" lazy-validation)
                v-layout(row,justify-center,full-height,align-center)
                    v-flex(xs2)
                    v-flex(xs6)
                        v-text-field(v-model="title",
                            :counter="30",
                            prepend-icon="assignment"
                            label="タスク",
                            name="title",
                            ref="title",
                            :rules="nameRules"
                            required)
                        v-menu(ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            :return-value.sync="date"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px")
                            template(v-slot:activator="{ on }")
                                v-text-field( v-model="date"
                                label="期限"
                                prepend-icon="event"
                                readonly
                                v-on="on")
                            v-date-picker(v-model="date",no-title,scrollable,locale="ja",:day-format="date => new Date(date).getDate()")
                                v-spacer
                                v-btn(flat color="primary" @click="menu = false") Cancel
                                v-btn(flat color="primary" @click="$refs.menu.save(date)") OK
                    v-flex(xs1)
                    v-flex(xs3)
                            v-btn(color="warning" @click="submit")
                                    span 更新

        </template>

<script lang="ts">
    function setDatetime(date:Date){
                date=new Date(date);
                return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate()
        }
    export default {
        name: "updateCard",
        data(){
                return {
                        card:{},
                        title:"",
                        menu:"",
                        date:"",
                        nameRules: [
                                v => !!v || '何か文字を入力してください',
                                v => v.length <= 30 || '30文字以内で記述してください。'
                                // エスケープ処理を追加
                        ],

                }
        },

        async created(){
                let self:any=this;
                await self.getData();
                self.card=await self.$store.getters.getCard;
                self.title=self.card.title;
                self.date=setDatetime(self.card.expiration);

        },

        methods:{
                async getData(){
                        let self:any=this;
                        await self.$store.dispatch('getTodoById',self.$route.params.id)
                },
                async submit(){
<<<<<<< HEAD
                        if (this.$refs.form.validate()) {
                            console.log(this.date);
                            this.card.title=this.title;
                            this.card.expiration=this.date;
                            await this.$store.dispatch('postTodo',this.card).then(()=>{
                                    console.log('Update the Card!')
                            }).then(res=>{
                                this.$router.push({ path: "/"})
                            });
                    }
=======
                        let self:any=this;
                        console.log(self.date);
                        self.card.title=self.title;
                        self.card.expiration=self.date;
                        await self.$store.dispatch('postTodo',self.card).then(()=>{
                                console.log('Update the Card!')
                        }).then((res:any)=>{
                                self.$router.push({ path: "/"})
                        });
>>>>>>> develop
                }
        }
    }
</script>

<style scoped>

</style>
