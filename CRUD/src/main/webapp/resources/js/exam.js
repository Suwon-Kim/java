var canvas,ctx,xr,yr,len,max;
canvas = document.getElementsByTagName('canvas')[0];
ctx = canvas.getContext('2d');
canvas.width=canvas.height=400;
init();
aaa();

function init(){
    var a,b,c,d;
    a=[1,2,3,5,7,11,13,17,19,23,29,31,37];
    xr=[];
    yr=[];
    c=(a.length-Math.random()*4)|0;
    len=a[c];
    max=(600/len)|0;
    a[c]=a[a.length-1];
    a.pop();
    for(b=0;b<5;b++){
        c=(Math.random()*a.length)|0;
        d=a[c];
        a[c]=a[a.length-1];
        a.pop();
        xr.push(d);
        c=(Math.random()*a.length)|0;
        d=a[c];
        a[c]=a[a.length-1];
        a.pop();
        yr.push(d);
    }
}

function aaa(){
    var a,b,c,tx,ty,x,y,r;
    ctx.globalCompositeOperation = "source-over";
    ctx.fillStyle="rgb(0,0,0)";
    ctx.fillRect(0,0,canvas.width,canvas.height);
    ctx.globalCompositeOperation = "lighter";
    tim=new Date().getTime()/70;
    lis(200,200,350*(1+Math.sin(tim/43)*0.2));
    requestAnimationFrame(aaa);
}

function lis(tx,ty,s){
    var a,b,c,d,r,r0,r1,xp,x,y,p,p1,px,py,x0,y0,x1,y1;
    ctx.lineWidth=3;
    xp=tim/37;
    
    r0=tim/29/len*10;
    for(a=0;a<len;a++){
        ctx.strokeStyle="rgba(111,111,111,0.5)";
        r=r0;
        ctx.beginPath();
        for(b=0;b<max;b++){
            d=pp(r);
            ctx.lineTo(tx+d[0],ty+d[1]);
            if(b==max-1)p0=d;
            r+=Math.PI*2/(max)/len/3*2;
        }
        ctx.stroke();
        
        p=[];
        p1=[];
        for(b=0;b<max;b++){
            c=b/(max-1);
            r1=r+Math.sin(c*Math.PI)/len*1.5;
            c=Math.sin(c*Math.PI)/len*3;
            d=pp(r1);
            x=d[0];
            y=d[1];
            d=pp(r1,1);
            px=d[0];
            py=d[1];
            x0=tx+x+py*c;
            y0=ty+y+px*c;
            x1=tx+x-py*c;
            y1=ty+y-px*c;
            p.push([x0,y0]);
            p1.push([x1,y1]);
            r+=Math.PI*2/(max-1)/len/3;
        }
        
        ctx.fillStyle="hsla("+((a*1113)%360)+",60%,60%,1.5)";
        ctx.beginPath();
        ctx.lineTo(tx+p0[0],ty+p0[1]);
        for(b=0;b<max;b++)ctx.lineTo(p[b][0],p[b][1]);
        for(b=max-1;b>=0;b--)ctx.lineTo(p1[b][0],p1[b][1]);
        ctx.stroke();
        ctx.fill();
        r0+=Math.PI*2/len;
    }
    
    function pp(r,gy){
        var a,x,y,cos,sin;
        if(gy){
            sin=Math.cos;
            cos=Math.sin;
        }else{
            cos=Math.cos;
            sin=Math.sin;
        }
        x=y=0;
        for(a=0;a<5;a++){
            x+=cos(r*xr[a]+xp+a)/(1+xr[a]/2+a);
            y+=sin(r*yr[a]+a)/(1+yr[a]/2+a);
        }
        return [x*s,y*s];
    }
}