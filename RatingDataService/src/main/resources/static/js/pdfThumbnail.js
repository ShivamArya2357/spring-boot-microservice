const url = 'http://localhost:8080/resources/s3bucket/PanCard.pdf';

let pdfDoc = null,
    pageNum = 1,
    pageIsRendering = false,
    pageNumIsPending = null;

const scale = 1.0;

canvas = document.querySelector('#pdf-render');
context = canvas.getContext('2d');

const renderPage = num => {
    pageIsRendering = true;
    pdfDoc.getPage(num).then(page => {
        const viewport = page.getViewport({ scale });
        canvas.height = viewport.height;
        canvas.width = viewport.width;
        const renderContext = {
            canvasContext: context,
            viewport: viewport
        }
        page.render(renderContext).promise.then(() => {
           pageIsRendering = false;
           if (pageNumIsPending !== null) {
               renderPage(pageNumIsPending);
               pageNumIsPending = null;
           }
        });
    });
};

pdfjsLib.getDocument(url).promise.then(pdfDoc_ => {

    pdfDoc = pdfDoc_;
    renderPage(pageNum);
});
