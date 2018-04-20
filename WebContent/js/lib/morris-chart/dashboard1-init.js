// Dashboard 1 Morris-chart
$( function () {
	"use strict";


	// Extra chart
	Morris.Area( {
		element: 'extra-area-chart',
		data: [ {
				period: '2001',
				profit: 0,
        }, {
				period: '2002',
				profit: 60,
        }, {
				period: '2003',
				profit: 10
        }, {
				period: '2004',
				profit: 0
        }, {
				period: '2005',
				profit: 0
        }, {
				period: '2006',
				profit: 75
        }, {
				period: '2007',
				profit: 120

        }


        ],
		lineColors: [ '#26DAD2'],
		xkey: 'period',
		ykeys: ['profit'],
		labels: [ '매출이익' ],
		pointSize: 0,
		lineWidth: 0,
		resize: true,
		fillOpacity: 0.8,
		behaveLikeLine: true,
		gridLineColor: '#e0e0e0',
		hideHover: 'auto'

	} );



} );
