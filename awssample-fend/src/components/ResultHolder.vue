<template>
    <div class="s3Wrapper">
        <q-btn v-if="!data.connetStatus" :label="props.from" @click="getData" />
        <q-list v-if="data.connetStatus" bordered>
            <q-item class="keepCenter">
                <q-item-section top avatar>
                    <h4 v-if="from == 'S3'">{{ data.title }}のファイル一覧</h4>
                    <h4 v-else-if="from == 'RDS'">{{ data.title }}のデータ一覧</h4>
                    <hr>
                </q-item-section>
            </q-item>
            <q-item v-if="from == 'S3'" @click="getS3File(item.key)" clickable v-ripple v-for="item in data.list">
                <q-item-section>{{ item.key }}</q-item-section>
                <q-item-section>{{ item.size }}kb</q-item-section>
            </q-item>

            <q-item v-else-if="from == 'RDS'" @click="getS3File(item.key)" clickable v-ripple v-for="item in data.list">
                <q-item-section>{{ item.key }}</q-item-section>
                <q-item-section>{{ item.size }}kb</q-item-section>
            </q-item>
        </q-list>
    </div>
</template>

<script setup>
const props = defineProps({
    dataFunction: Object,
    from: String,
    btnName: String
});

const data = ref({
    connetStatus: false
});

const getData = async () => {
    data.list = await props.dataFunction();
    if (data.list) {
        data.connetStatus = true
    }
}
</script>

<style scoped>
.s3Wrapper {
    width: 60vw;
    height: 80vh;
    padding: 20px;
    border: 1px solid var(--color-border);
}

.q-list--bordered {
    border: none;
}
</style>