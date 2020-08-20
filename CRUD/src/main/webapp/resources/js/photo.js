$(() => {
  const $products = $(".products").children();

  const toggle = $product => {
    $product.toggleClass("hidden");
  }
  
  const randomProductToggle = () => {
    setTimeout(() => {
      toggleRandom();
      randomProductToggle();
    }, Math.random() * 1000)
  };
  
  const toggleRandom = () => {
    const random = Math.floor((Math.random() * $products.length) + 1);
    const $product = $products.eq(random);
    
    toggle($product);
  }

  const setInitialZindex = () => {
    let column = 3;
    
    $products.each((i, product) => {
      $(product).css({
        "z-index": column * 100 + i
      });

      column--;

      if (column === 0) {
        column = 3;
      }
    });
  };

  $products.on("click", function() {
    toggle($(this));
  });

  setInitialZindex();
  randomProductToggle();
});