<template lang="pug">
    v-card
        v-card-title
            h3 新しくカードを作成する
        v-card-text
            v-flex(xs8)
                v-form
                   v-text-field(v-model="title",
                       :rules="nameRules",:counter="30",
                       label="Name",
                       required)




</template>

<script>
    export default {
        name: "MainCard",
        data: () => ({
            date: new Date().toISOString().substr(0, 10),
            valid: false,
            name: '',
            nameRules: [
                v => !!v || 'Name is required',
                v => v.length <= 10 || 'Name must be less than 10 characters'
                // エスケープ処理を追加

            ],
        }),

    }
</script>

<style scoped>

</style>