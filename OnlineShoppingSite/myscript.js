function startTimer() {
	var id=setInterval(displayNextImage,3000);
}

var image=[],x=-1;

image[0]="cover2.jpg";
image[1]="cover3.jpg";
image[2]="cover4.jpg";
image[3]="cover.jpg";
image[4]="cover1.jpg";

function displayNextImage() {

	x=(x===image.length-1)?0:x+1;
	document.getElementById('coverimg').src=image[x];	

}


