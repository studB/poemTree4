<template>
  <div class="list-wrapper">
    <div class="list-header">
      <div v-on:mousedown="resize"></div>
      <div id="sample"></div>
    </div>
    <div class="list-body"></div>
  </div>
</template>

<script>
export default {
  name: 'note-list',
  methods: {
    resize : function(event) {
      console.log(event);
    }
  }
}
</script>

<style>

.list-wrapper {
  border: 1px solid red;
  height: inherit;
}

.list-wrapper .list-header {
  height: 20px;
  background-color: plum;
}

.list-wrapper .list-header > div {
  width: 10px;
  height: 10px;
  background: red;
}

#sample{
  width: 5px;
  height: 10px;
  background-color: blue;
}

</style>