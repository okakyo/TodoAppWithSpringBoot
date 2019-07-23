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
                        prepend-icon="assignment"
                        label="タスク",
                        name="title",
                        ref="title",
                        required)

</template>

<script>
    export default {
        name: "SearchCard"
    }
</script>

<style scoped>

</style>
