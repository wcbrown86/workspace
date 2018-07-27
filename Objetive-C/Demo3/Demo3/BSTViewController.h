//
//  BSTViewController.h
//  Demo3
//
//  Created by William Brown on 12/19/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface BSTViewController : UIViewController


@property (weak, nonatomic) IBOutlet UITextField *myTextField;

@property (weak, nonatomic) IBOutlet UILabel *myLabel;

- (IBAction)changeText:(id)sender;

- (IBAction)dismissKeyBoard:(id)sender;



@end
