<template lang="pug">
    v-card
        v-card-title
            h2 新しいTodoを作成する
        v-divider
        v-card-text
            v-form(v-model="isValid",ref="form" )
                v-layout(row,justify-center,full-height,align-center)
                    v-flex(xs2)
                    v-flex(xs6)
                            v-text-field(v-model="title",
                                    :rules="nameRules",:counter="30",
                                    prepend-icon="assignment"
                                    label="タスク",
                                    name="title",
                                    ref="title",
                                    required)
                            v-menu(ref="menu"
                                    :rules="expirationRules"
                                    :close-on-content-click="false"
                                    :nudge-right="40"
                                    :return-value.sync="date"
                                    lazy
                                    transition="scale-transition"
                                    offset-y
                                    full-width
                                    min-width="290px"
                                    required)
                                    template(v-slot:activator="{ on }")
                                            v-text-field( v-model="date"
                                                    label="期限"
                                                    prepend-icon="event"
                                                    readonly
                                                    ref="date"
                                                    v-on="on")
                                    v-date-picker(v-model="date",no-title,scrollable,locale="ja",:day-format=" new Date(date).getDate()")
                                            v-spacer
                                            v-btn(flat color="primary" @click="menu = false") Cancel
                                            v-btn(flat color="primary" @click="$refs.menu.save(date)") OK
                    v-flex(xs1)
                    v-flex(xs3)
                            v-btn(color="warning"  @click="submit" )
                                    span 提出
        </template>

        <script>
            export default {
                name: "MainCard",
                data(){return {
                        date:"",

                        title: "",
                        menu:"",
                        nameRules: [
                                v => !!v || '何か文字を入力してください',
                                v => v.length <= 30 || '30文字以内で記述してください。'
                                // エスケープ処理を追加
                        ],
                        expirationRules:[
                                v=>!!v || '日時を設定ください'
                        ]

                }},


                methods:{
                        async submit(){

                                await self.$store.dispatch('postTodo',{
                                                title:self.title,
                                                expiration:self.date,
                                        }).then(()=>{
                                                console.log('Add an New Card!')
                                        });
                                }
                        },

    }
</script>

<style scoped>

</style>
