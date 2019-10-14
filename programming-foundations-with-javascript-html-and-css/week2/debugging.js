var img = new SimpleImage(200,200);
for (var px of img.values()){
  var x = px.getX();
  var y = px.getY();
  if (y>img.getHeight()/2){
    px.setBlue(255);
  }
  else {
    px.setGreen(255);
  }
  if (x < img.getWidth()/2){
    px.setGreen(0);
    px.setRed(255);
  }
}
print (img);