
            <div class="row" >
                <div class="col-lg-12">
                    <h1 class="page-header">Describe Product</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row" >
                <div class="col-lg-12">
                    <div class="panel panel-default">  
                        <div class="panel-heading">
                            Product Description
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form">
                                        <div class="form-group">
                                            <label>Product Name</label>
                                            <input ng-model="product.productName" class="form-control" required="true" placeholder="Enter Unique Product Name">
                                        </div>
										<div class="form-group">
                                            <label>Location Type</label>
                                            <!-- product.categoryMaster.locationType -->
                                            <!-- <select class="form-control" data-ng-model="locType" ng-change="fetchCategoryByLocType(locType)">
	                                            <option value="" ng-selected="selected">Select</option>
												<option ng-repeat="locType in locationTypes" value='{{locType.typeId}}'>{{locType.type}}</option>
                                            </select> -->
                                            
                                            
                                            <select class="form-control" data-ng-model="locType" data-ng-options="locType as locType.type for locType in locationTypes"
												ng-change="fetchCategoryByLocType(locType)">
												<option value="">Select	<option />
											</select>
                                            <!-- <input class="form-control" placeholder="Select location area where product will be placed"> -->
                                        </div>
                                        <div class="form-group">
                                            <label>Category</label>
                                            <select class="form-control" data-ng-model="categoryMaster" ng-change="showSubCategoryByCat(categoryMaster)"
                                            data-ng-options="category as category.category for category in locCategoryList">
                                                <option value="">Select</option>
                                            </select> 
                                        </div>
                                        <div class="form-group">
                                            <label>Sub Category</label>
                                            <select class="form-control" data-ng-model="subCategory" data-ng-options="subCat as subCat.subCategory for subCat in subCategories" >
												<option value="">Select	<option />
											</select>

                                        </div>

                                        <div class="form-group">
                                            <label>Key Features</label>
                                            <input class="form-control" ng-model="product.keyFeatures" placeholder="Key features, like metallic, leatherite, special wood/clothing">
                                        </div>
                                        <div class="form-group">
                                            <label>Colors</label>
                                            <input class="form-control" ng-model="product.colors" placeholder="Choose/Enter prominent colors, or color-combinations">
                                        </div>

                                        <label>MRP</label>

                                        <div class="form-group input-group">
                                            <span class="input-group-addon">Rs.</span>
											<input class="form-control" ng-model="product.mrp" placeholder="MRP of product ( 1 Item)">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                        <div class="form-group">
                                            <label>Discount</label>
                                            <input class="form-control" ng-model="product.discount" placeholder="% discount offered on MRP by seller/Store">
                                        </div>                                        
                                        
                                        <div class="form-group">
                                            <label>Sale Price</label>
                                            <div class="form-group input-group">
                                            	<span class="input-group-addon">Rs</span>
												<input ng-model="product.salePrice" class="form-control" placeholder="Sale price of product">
                                            	<span class="input-group-addon">.00</span>
                                       		 </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>Stock Quantity</label>
                                            <input ng-model="product.stockQuantity" class="form-control" placeholder="No of items available in your store">
                                        </div>
                                        <div class="form-group">
                                            <label>Package Content</label>
                                            <input ng-model="product.packageContent" class="form-control" placeholder="Package Content count, including/excluding items">
                                        </div>
                                        <div class="form-group">
                                            <label>Warranty</label>
                                            <input  ng-model="product.warranty" class="form-control" placeholder="Warranty in months">
                                        </div>

                                       
                                        <button type="submit" class="btn btn-primary" ng-submit="saveProduct();">Submit Button</button>
                                        <button type="reset" class="btn btn-primary">Reset Button</button>
                                    </form>
                                </div>

                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->


