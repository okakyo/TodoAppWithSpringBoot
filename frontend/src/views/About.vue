<template lang="pug">
    .about
        SearchCard
        TODOCard
</template>
<script>
    import TODOCard from "../components/todocard";
    import SearchCard from "../components/SearchCard";
    export default {
        components: {SearchCard, TODOCard}
    }
</script>