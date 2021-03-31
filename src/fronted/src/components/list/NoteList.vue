<template>
  <div class="list-wrapper">
    <div class="list-header">
      <div v-on:mousedown="resize($event)" id="sample">*</div>
    </div>
    <div class="list-body"></div>
  </div>
</template>

<script>

var startX, startWidth;
var sectionElmt = document.querySelector('.list');

export default {
  name: 'note-list',
  methods: {
    resize : function(event) {

      // http://jsfiddle.net/MissoulaLorenzo/gfn6ob3j/

      startX = event.clientX;
      sectionElmt = document.querySelector('.list');
      startWidth = parseInt( document.defaultView.getComputedStyle(sectionElmt).width, 10);
      
      document.documentElement.addEventListener('mousemove', this.doDrag, false);
      document.documentElement.addEventListener('mouseup', this.stopDrag, false);
    },
    doDrag : function(event){
      sectionElmt.style.width = (startWidth + event.clientX - startX) + 'px';
    },
    stopDrag : function(){
      document.documentElement.removeEventListener('mousemove', this.doDrag, false);
      document.documentElement.removeEventListener('mouseup', this.stopDrag, false);
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
  width: 20px;
  height: 20px;
  background-color: blue;
  float: right;
}

</style>