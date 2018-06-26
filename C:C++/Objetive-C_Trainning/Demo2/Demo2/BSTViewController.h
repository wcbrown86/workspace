//
//  BSTViewController.h
//  Demo2
//
//  Created by William Brown on 12/19/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface BSTViewController : UIViewController

- (IBAction)changeLable:(id)sender;

@property (weak, nonatomic) IBOutlet UILabel *textLabel;

@property (weak, nonatomic) IBOutlet UITextField *textField;

@end
